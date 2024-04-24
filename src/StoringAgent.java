import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class StoringAgent extends Agent {
    protected void setup() {
        System.out.println("Storing Agent " + getLocalName() + " ready to store data.");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Storing data: " + msg.getContent());
                    // Ici, vous pourriez interagir avec une base de données ou un système de
                    // fichiers
                    ACLMessage reply = msg.createReply();
                    reply.setPerformative(ACLMessage.CONFIRM);
                    reply.setContent("Data stored successfully: " + msg.getContent());
                    send(reply);
                }
                block();
            }
        });
    }
}
