public class Contrller {
    private MainFrame mainFrame;

    public Controller() {
        mainFrame = new MainFrame();
    }
    
    public final goToMenu() {
        mainFrame.setPanel(mainFrame.getProduzionePanel());
    }
}
