
package cure_inc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MainFrame extends JFrame implements ActionListener{
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private JPanel buttonPanel;
    private JLabel title;
    private final Font LABEL_1_FONT = new Font("Arial",Font.BOLD,52);
    private final Color LIGHT_BLUE = new Color(33, 204, 255);
    private JButton exiter;
    public MainFrame(){
        super();
        exiter = new JButton("Exit");
        exiter.addActionListener(this);
        easy = new JButton("Easy");
        easy.addActionListener(this);
        
        medium = new JButton("Medium");
        medium.addActionListener(this);
        
        hard = new JButton("Hard");
        hard.addActionListener(this);
        
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(easy);
        buttonPanel.add(medium);
        buttonPanel.add(hard);
        
        title = new JLabel("Cure Inc.", SwingConstants.CENTER);
        java.net.URL logoPic = getClass().getResource("1.png");
       
        ImageIcon logo = new ImageIcon(new ImageIcon(logoPic).getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT));
        title.setFont(LABEL_1_FONT);
        JLabel pic = new JLabel(logo, SwingConstants.CENTER);
        pic.setBackground(LIGHT_BLUE);
        easy.setPreferredSize(new Dimension(150, 80));
        medium.setPreferredSize(new Dimension(150, 80));
        hard.setPreferredSize(new Dimension(150, 80));
        buttonPanel.add(exiter);
        exiter.setPreferredSize(new Dimension(150, 80));
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(pic, BorderLayout.SOUTH);
        buttonPanel.setBackground(LIGHT_BLUE);
        
       
        
        this.setBounds(320, 10, 800, 800);
        this.getContentPane().setBackground(LIGHT_BLUE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        MainFrame menu = new MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
         
        if(command.equals("Easy")){
            GameFrame easyMode = new GameFrame(1.002, .011);
            this.dispose();
        }else if(command.equals("Medium")){
            GameFrame mediumMode = new GameFrame(1.004, .02);
            this.dispose();
        }else if(command.equals("Hard")){
            GameFrame hardMode = new GameFrame(1.006, .04);
            this.dispose();
        }else if(command.equals("Exit")){
            System.exit(0);
        }
        
    }
    
}
