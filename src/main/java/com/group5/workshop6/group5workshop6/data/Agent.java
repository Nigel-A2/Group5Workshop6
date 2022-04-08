package com.group5.workshop6.group5workshop6.data;

/**
 * Class representing the data for a travel agent
 * */
public class Agent {
    private int Id;
    private String firstName, middleInitial, lastName;
    private String businessPhone, email;
    private String position;
    private int agencyId;

    // Constructor
    public Agent(int id, String firstName, String middleInitial, String lastName, String businessPhone, String email, String position, int agencyId) {
        Id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.businessPhone = businessPhone;
        this.email = email;
        this.position = position;
        this.agencyId = agencyId;
    }

    /**
     * Get the agent's first name
     * @return The agent's first name
     * */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the agent's first name
     * @param firstName The first name to set
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the agent's middle initial
     * @return The agent's middle initial
     * */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the agent's middle initial
     * @param middleInitial The middle initial to set
     * */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * Get the agent's last name
     * @return The agent's last name
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the agent's last name
     * @param lastName The last name to set
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the agent's business phone number
     * @return The agent's business phone
     * */
    public String getBusinessPhone() {
        return businessPhone;
    }

    /**
     * Sets the agent's business phone
     * @param businessPhone The business phone number to set
     * */
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    /**
     * Get the agent's email address
     * @return The agent's email
     * */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the agent's email address
     * @param email The new email address to set
     * */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the agent's position/job title
     * @return The agent's position/job title
     * */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the agent's position/job title
     * @param position The position/job title to set
     * */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Get the id of the agency this agent works for
     * @return The id of the agency
     * */
    public int getAgencyId() {
        return agencyId;
    }

    /**
     * Sets the agent's agency ID
     * @param agencyId The ID of the new agency they are now working for
     * */
    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * Get the id of this data record
     * @return The agent's id
     * */
    public int getId() {
        return Id;
    }
}
