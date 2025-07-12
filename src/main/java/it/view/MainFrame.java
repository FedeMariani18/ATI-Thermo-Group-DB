public class MainFrame {
    private final int width = 800;
    private final int height = 600;
    private final Jpanel panel; 

    public MainFrame() {
        JFrame frame = new JFrame("Main Frame");
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setPanel(JPanel newPanel) {
        this.panel = newPanel;
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    public ProduzionePanel getProduzionePanel() {
        return ProduzionePanel produzionePanel = new ProduzionePanel();
    }


}
