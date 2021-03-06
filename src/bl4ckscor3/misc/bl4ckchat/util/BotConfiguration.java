package bl4ckscor3.misc.bl4ckchat.util;

public class BotConfiguration
{
	private String name;
	private String network;
	private int port;
	private String serverPassword;
	private String nickserv;
	private String[] channels;
	private boolean ssl;

	public BotConfiguration(String na, String ne, String p, String sp, String ni, String channel, boolean s)
	{
		name = na;
		network = ne;
		port = p.equals("") ? 0 : Integer.parseInt(p);
		serverPassword = sp;
		nickserv = ni;
		channels = channel.split(",");
		ssl = s;
	}

	public void setName(String n)
	{
		name = n;
	}

	public void setNetwork(String n)
	{
		network = n;
	}

	public void setPort(int p)
	{
		port = p;
	}

	public String getName()
	{
		return name;
	}
	
	public String getNetwork()
	{
		return network;
	}
	
	public int getPort()
	{
		return port;
	}
	
	public String getServerPassword()
	{
		return serverPassword;
	}
	
	public String getNickserv()
	{
		return nickserv;
	}
	
	public String[] getChannels()
	{
		return channels;
	}
	
	public boolean useSsl()
	{
		return ssl;
	}
}
