import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ComputingAgent extends Agent {
    protected void setup() {
        System.out.println("Computing Agent " + getLocalName() + " started for computing.");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Computing from data: " + msg.getContent());
                    // Traitement des données, ex: analyse d'image
                    ACLMessage reply = msg.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent("Analysis completed: Potential fire detected");
                    send(reply);
                }
                block();
            }
        });
    }
}
