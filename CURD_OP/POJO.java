package JDBC_;

public class POJO {
	
	private int c_id;
	private String c_name;
	
	private double c_fee;
	private String c_struct;
	
	
	public String getC_name()
	{
		return c_name;
	}
	public void setC_name(String c_name) 
	{
		this.c_name = c_name;
	}
	public int getC_id() 
	{
		return c_id;
	}
	public void setC_id(double cid)
	{
		this.c_id = (int) cid;
	}
	public double getC_fee() 
	{
		return c_fee;
	}
	public void setC_fee(double c_fee)
	{
		this.c_fee = c_fee;
	}
	public String getC_struct()
	{
		return c_struct;
	}
	public void setC_struct(String c_struct) 
	{
		this.c_struct = c_struct;
	}
	
	
	
}
