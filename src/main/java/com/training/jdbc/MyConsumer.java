package com.training.jdbc;

public class MyConsumer {
	private int id;
	private String Name;	
	private int units;
	private double charge = 0;
	public MyConsumer(int consumer_number, String consumer_name, int units_consumption) {
		this.id = consumer_number;
		this.Name = consumer_name;
		this.units = units_consumption;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}

	public double CalcMonthlyCharge(int unit) {
		if (unit < 50) {
			//System.out.println("Throw an error");
			charge = 0;
		}
		else if(unit>=50 && unit <= 200)
		{
			charge = 50.00;
		}
		else if(unit>200 && unit <= 500)
		{
			charge = 50 +  (unit-200) * 1.25;
		}
		else if(unit>500 && unit <= 1000)
		{
			charge = 50 + (unit-500) * 1.00 + 300*1.25;
		}
		else if(unit>1000)
		{
			charge = (unit-100) * 0.75 + 50 + (unit-500) * 1.00 + 300*1.25;
		}
		return charge;
	}
}
