import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Title      : UserInterface.java
 * Description: This class contains definition of user interface.
 * @author      Zhuoda Liu
 * @version     2.5
 */

public class UserInterface extends JFrame{
    
    /**
     *  Consruct method.
     */
    public UserInterface(){
        
        JPanel gui = new JPanel(); //the root panel of the frame

        //initiate the layout of the panel
        GridBagLayout gblayout=new GridBagLayout();
        gui.setLayout(gblayout);
        GridBagConstraints g=new GridBagConstraints();
        g.fill=GridBagConstraints.BOTH;
        g.insets=new Insets(5, 5, 5, 5);
        g.gridwidth=1;
        g.gridheight=1;

        Display display = new Display(); //conponents in the panel
        
        //set title configs
        JPanel title  = new JPanel();
        JLabel label = new JLabel("Wordle");
        label.setFont(new Font("Verdana", Font.BOLD, 30));
        label.setPreferredSize(new Dimension(300,50));
        label.setHorizontalAlignment(JLabel.CENTER);
        title.add(label);
        g.gridy=0;
        g.gridx=0;
        gblayout.setConstraints(title, g);
        gui.add(title);

        //set screen
        g.gridy=1;
        g.gridx=0;
        gblayout.setConstraints(display.screen, g);
        gui.add(display.screen);
        

        //set keyboard
        g.gridy=2;
        g.gridx=0;
        gblayout.setConstraints(display.keyboard, g);
        gui.add(display.keyboard);

        //set frame configs
        setTitle("Wordle");
        setContentPane(gui);
		setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setFrameCenter();

        //show user guide the first time enter the game
        JOptionPane.showOptionDialog(null, "Guess a word in six tries.\nEach guess must be a valid five-letter word.\nHit the confirm button to submit or hit the delete button to delete the previous character.\nAfter each guess, the color of the tiles will change to show how close your guess was to the word.\nGreen stands for correct character, yellow stands for wrong spot and gray stands for not contained in the word.", "Guide", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
    }
    
    /**
     *  Set the frame to the center of user screen.
     */
    public void setFrameCenter(){

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();        
        
        //get the location of the center point
        int x = (dimension.width-getWidth())/2;
        
        int y = (dimension.height-getHeight())/2;
        
        setLocation(x, y);
    }

    /**
     *  Main method to run the game.
     */
    public static void main(String[] args){
        new UserInterface();
    }
}
