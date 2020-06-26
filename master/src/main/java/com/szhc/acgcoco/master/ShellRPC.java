package com.szhc.acgcoco.master;

import ch.ethz.ssh2.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class ShellRPC {

    private static Connection conn;
    private static String ip;
    private static String userName;
    private static String password;
    private static String charset = Charset.defaultCharset().toString();
    private static final int TIME_OUT = 1000 * 5 * 60;
    private static InputStream stdOut = null;
    private static InputStream stdErr = null;

    public static void inti(String confPath) {
        System.out.println("读取配置文件中...............");
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(confPath));
            properties.load(bufferedReader);
            // 获取key对应的value值
            ip = properties.getProperty("ip");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
            System.out.println("ip：" + ip);
            System.out.println("userName：" + userName);
            System.out.println("password：" + password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("读取异常....................");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载配置文件异常...............");
        }

        try {
            System.out.println("建立连接.......................");
            getConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("连接异常..........................");
        }
    }

    public static void stop(){
        if (conn != null) {
            conn.close();
        }
        if(stdOut!=null) {
            try {
                stdOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(stdErr!=null) {
            try {
                stdErr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("关闭连接......................................");
    }


    /**
     * 连接
     *
     * @return
     * @throws IOException
     */
    private static boolean getConnection() throws IOException {
        conn = new Connection(ip);
        conn.connect();

        return conn.authenticateWithPassword(userName, password);
    }


    public static void issue(String filePath, String serverName) {
        try {
            System.out.println("停止服务........................");
            exec("sh /www/server/"+serverName+"Stop.sh");
            exec("rm -fr /www/server/"+serverName+".jar");
            System.out.println("上传文件........................");
            putFile(conn,filePath,"/www/server");
            System.out.println("启动服务........................");
            exec("sh /www/server/"+serverName+"Start.sh");
            stop();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常..........................");
        }
    }

    public static void main(String[] args) throws Exception {
        inti("C:\\server.properties");
        exec("cd /www/server");
        exec("./apiStart.sh");
        stop();
    }


    /**
     * 执行脚本
     *
     * @param cmds
     * @return
     * @throws Exception
     */
    private static int exec(String cmds) throws Exception {
        String outStr = "";
        String outErr = "";
        int ret = -1;
        try {
            // Open a new {@link Session} on this connection
            Session session = conn.openSession();
            // Execute a command on the remote machine.
            session.execCommand(cmds);
            stdOut = new StreamGobbler(session.getStdout());
            outStr = processStream(stdOut, charset);
            System.out.println("执行信息系：" + outStr);
            stdErr = new StreamGobbler(session.getStderr());
            outErr = processStream(stdErr, charset);
            System.out.println("执行异常：" + outErr);
            session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
            ret = session.getExitStatus();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * @param in
     * @param charset
     * @return
     * @throws Exception
     */
    private static String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, charset));
        }
        return sb.toString();
    }




    /**
     * 实现下载服务器上的文件到本地指定目录
     *
     * @param conn      SSH连接信息
     * @param fileName  服务器上的文件地址/opt/rpc/log/order/all.log
     * @param localPath 本地路径：D:\
     * @throws IOException
     */

    private void getFile(Connection conn, String fileName, String localPath) throws IOException {

        SCPClient scpClient = conn.createSCPClient();
        //String logPath="cd /opt/rpc/log/order";
        Session session = conn.openSession();
        session.execCommand("");//执行shell命令
        scpClient.get(fileName, localPath);

    }

    /**
     * 实现上传本地文件到服务器上指定目录
     *
     * @param conn      SSH连接信息
     * @param fileName  D:\a.txt
     * @param localPath 服务器地址路径：/opt/rpc/log/order
     * @throws IOException
     */
    private static void putFile(Connection conn, String fileName, String localPath) throws IOException {

        SCPClient scpClient = conn.createSCPClient();
      //  scpClient.
        scpClient.put(fileName, localPath);
    }


}