<<<<<<< HEAD
package com.group5.workshop6.group5workshop6.data;

import com.group5.workshop6.group5workshop6.ConnectionManager;
=======
package ca.natepenner.assignment2day6;
>>>>>>> nate

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Business class to simplify database interaction with the agents table
 * */
public class AgentManager {

    /**
     * Get a list of the integer ids of all the agents
     * @return A list of agent ids, or an empty list if anything goes wrong
     * */
    static List<Integer> getAgentIdList() {
        Connection conn = ConnectionManager.getConnection();
        List<Integer> agentIdList = new ArrayList<>();

        if (conn == null) {
            System.err.println("No connection available.");
            return agentIdList;
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT AgentId FROM agents ORDER BY AgentId";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                agentIdList.add(results.getInt(1));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agentIdList;
    }

    /**
     * Get data about an agent based on their id
     * @param id The id of the agent to retrieve
     * @return The agent data as an Agent object, or null if that agent doesn't exist
     * */
    static Agent getAgentById(int id) {
        Connection conn = ConnectionManager.getConnection();
        Agent agent = null;

        if (conn == null) {
            System.err.println("No connection available.");
            return agent;
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM agents WHERE AgentId = " + id;
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                agent = new Agent(
                        results.getInt(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5),
                        results.getString(6),
                        results.getString(7),
                        results.getInt(8)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agent;
    }

    /**
     * Update the data of an agent
     * @param agent The new agent data to store in the database
     * */
    static boolean updateAgent(Agent agent) {
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null)
                return false;

            String query = "UPDATE agents SET AgtFirstName = ?, AgtMiddleInitial = ?, AgtLastName = ?, "+
                    "AgtBusPhone = ?, AgtEmail = ?, AgtPosition = ?, AgencyId = ? WHERE AgentId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, agent.getFirstName());
            stmt.setString(2, agent.getMiddleInitial());
            stmt.setString(3, agent.getLastName());
            stmt.setString(4, agent.getBusinessPhone());
            stmt.setString(5, agent.getEmail());
            stmt.setString(6, agent.getPosition());
            stmt.setInt(7, agent.getAgencyId());
            stmt.setInt(8, agent.getId());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
