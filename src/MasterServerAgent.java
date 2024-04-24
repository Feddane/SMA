import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class MasterServerAgent extends Agent {
    protected void setup() {
        System.out.println("Master Server " + getLocalName() + " started.");
        // Envoie une requête initiale pour démarrer l'analyse
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.setContent("Start analysis of forest regions");
        msg.addReceiver(new jade.core.AID("computingAgent", jade.core.AID.ISLOCALNAME));
        send(msg);

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Master Server received: " + msg.getContent());
                    // Réponse ou actions supplémentaires peuvent être ajoutées ici
                }
                block();
            }
        });
    }
}
