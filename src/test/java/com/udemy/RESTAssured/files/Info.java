package com.udemy.RESTAssured.files;

import java.util.List;

public class Info {
	
	private String URL;
	private String services;
	private String expertise;
	private String instructor;
	private InfoCourses courses;
	private String linkedIN;
	
	public String getURL() { return URL; }
	public void setURL(String uRL) { URL = uRL; }
	
	public String getServices() { return services; }
	public void setServices(String services) { this.services = services; }
	
	public String getExpertise() { return expertise; }
	public void setExpertise(String expertise) { this.expertise = expertise; }
	
	public String getInstructor() { return instructor; }
	public void setInstructor(String instructor) { this.instructor = instructor; }
	
	public InfoCourses getCourses() { return courses; }
	public void setCourses(InfoCourses courses) { this.courses = courses; }
	
	public String getLinkedIN() { return linkedIN; }
	public void setLinkedIN(String linkedIN) { this.linkedIN = linkedIN; }
	
	//----------------
	private String type;
	private String name;
	private String ppu;
	private battersInfo batters;
	private List<toppingTest> topping;
	private int id;
	
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPpu() { return ppu; }
    public void setPpu(String ppu) { this.ppu = ppu; }

    public battersInfo getBatters() { return batters; }
    public void setBatters(battersInfo batters) { this.batters = batters; }

    public List<toppingTest> getTopping() { return topping; }
    public void setTopping(List<toppingTest> topping) { this.topping = topping; }

}
