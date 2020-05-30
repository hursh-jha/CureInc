package cure_inc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Anouncement  extends JFrame implements ActionListener{

    private JButton exiter;
    private JLabel displayLabel;
    private final Color LIGHT_BLUE = new Color(33, 204, 255);
    
    public Anouncement(String display){
        super();
        this.setBounds(10,10,700,600);       
        this.getContentPane().setBackground(LIGHT_BLUE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        exiter = new JButton("Close");
        exiter.addActionListener(this);
        
        displayLabel = new JLabel(display);
        
        this.add(displayLabel, BorderLayout.NORTH);
        this.add(exiter, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        //closing
        if(buttonClick.equals("Close")){ 
            this.dispose();
        }
    }
}
