package com.spring4.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageProducer {

	public static void main(String[] args) {
		try{
			// Create a ConnectionFactory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
			// Create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			// Create a Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//Create the destination
			Destination destination = session.createQueue("testQ");
			// Create a messageProducer from the session to the queue
			javax.jms.MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// Create a messages
			TextMessage message = session.createTextMessage("Hello World!!!");
			producer.send(message);
			producer.close();
			session.close();
			connection.close();
			System.out.println("Message Sent");
		}catch(Exception exception){
			System.out.println(exception);
		}
	}

}
