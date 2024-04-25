import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class MasterServerAgent extends Agent {
    protected void setup() {
        System.out.println("Master Server Agent " + getLocalName() + " started.");
        // Envoie une requête initiale pour démarrer l'analyse
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.setContent("analysis of forest regions");
        msg.addReceiver(new jade.core.AID("computingAgent", jade.core.AID.ISLOCALNAME));
        send(msg);

        // Envoie également un message au StoringAgent
        ACLMessage msgToStoringAgent = new ACLMessage(ACLMessage.REQUEST);
        msgToStoringAgent.setContent("Data for storage");
        msgToStoringAgent.addReceiver(new jade.core.AID("storingAgent", jade.core.AID.ISLOCALNAME));
        send(msgToStoringAgent);

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Master Server received: " + msg.getContent());
                }
                block();
            }
        });
    }
}
