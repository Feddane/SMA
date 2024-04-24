import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.core.Profile;
import jade.core.ProfileImpl;

public class Main {
    public static void main(String[] args) {
        try {
            // Créer un runtime JADE
            Runtime rt = Runtime.instance();

            // Créer un profil JADE
            Profile profile = new ProfileImpl();

            // Créer un conteneur principal
            AgentContainer mainContainer = rt.createMainContainer(profile);

            // Créer et démarrer l'agent principal (MasterServerAgent)
            AgentController masterServerAgent = mainContainer.createNewAgent("masterServer", "MasterServerAgent", null);
            masterServerAgent.start();

            // Créer et demarrer les autres agents
            AgentController computingAgent = mainContainer.createNewAgent("computingAgent", "ComputingAgent", null);
            computingAgent.start();

            AgentController storingAgent = mainContainer.createNewAgent("storingAgent", "StoringAgent", null);
            storingAgent.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
