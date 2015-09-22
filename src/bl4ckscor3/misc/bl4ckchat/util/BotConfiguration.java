package bl4ckscor3.misc.bl4ckchat.util;

public class BotConfiguration
{
	private String name;
	private String network;
	private int port;
	private String nickserv;

	public BotConfiguration(String na, String ne, String p, String ni)
	{
		name = na;
		network = ne;
		
		port = p.equals("") ? 0 : Integer.parseInt(p);
		nickserv = ni;
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

	public void setNickserv(String n)
	{
		nickserv = n;
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
	
	public String getNickserv()
	{
		return nickserv;
	}
}
