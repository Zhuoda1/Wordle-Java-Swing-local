import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * Title      : Display.java
 * Description: This class contains definition of components of the GUI.
 * @author      Zhuoda Liu
 * @version     3.9
 */

public class Display implements ActionListener{
    
    /**
     * The keyboard to enter characters
    */
    JPanel keyboard = new JPanel();
    
    /**
     * The screen that shows the word entered
    */
    JPanel screen = new JPanel();

    /**
     * Manage all keyboard buttons except delete and confirm
    */
    Map<String, JButton> map = new HashMap<String, JButton>();

    /**
     * Manage all screen labels
    */
    JLabel[][] screentext = new JLabel[6][5];
    
    /**
     * Current line
    */
    int curAttampt;

    /**
     * Current location in a line
    */
    int curLocation;

    /**
     * Current word to guess
    */
    String curWord = new String();

    /**
     * Current guess from user
    */
    StringBuilder curGuess;

    /**
     * Word list of 5 character words
    */
    List<String> wordList = new ArrayList<String>();


    /**
     *  Construct method, initiate keyboard and screen
     */
    public Display(){

        //initiate keyboard
        initKeyboard();

        //initiate screen
        initScreen();
        
        //initial other attributes
        this.curAttampt = 0;
        this.curGuess = new StringBuilder();
        this.curLocation = 0;
        this.loadWord();
        this.resetWord();
    }


    /*--------------------------methods to manipulate keyboard-----------------------*/

    /**
     * Reset the keyboard color to inital color.
    */
    public void resetKeyboardColor(){
        for(JButton bu : map.values()){
            bu.setBackground(UIManager.getColor("panelButtons.background"));
        }
    }
    
    /**
     * Initial keyboard configs
    */
    public void initKeyboard(){

        //initial the layout configs of the keyboard panel
        GridBagLayout gblayout=new GridBagLayout();
        this.keyboard.setLayout(gblayout);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(3, 2, 3, 2);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.ipadx=30;
        gbc.ipady=15;

        //add keyboard line 1
        gbc.gridy=0;

        gbc.gridx=0;
        JButton q = new JButton("q");
        gblayout.setConstraints(q, gbc);
        gbc.gridx=1;
        JButton w = new JButton("w");
        gblayout.setConstraints(w, gbc);
        gbc.gridx=2;
        JButton e = new JButton("e");
        gblayout.setConstraints(e, gbc);
        gbc.gridx=3;
        JButton r = new JButton("r");
        gblayout.setConstraints(r, gbc);
        gbc.gridx=4;
        JButton t = new JButton("t");
        gblayout.setConstraints(t, gbc);
        gbc.gridx=5;
        JButton y = new JButton("y");
        gblayout.setConstraints(y, gbc);
        gbc.gridx=6;
        JButton u = new JButton("u");
        gblayout.setConstraints(u, gbc);
        gbc.gridx=7;
        JButton i = new JButton("i");
        gblayout.setConstraints(i, gbc);
        gbc.gridx=8;
        JButton o = new JButton("o");
        gblayout.setConstraints(o, gbc);
        gbc.gridx=9;
        JButton p = new JButton("p");
        gblayout.setConstraints(p, gbc);


        //add keyboard line 2
        gbc.gridy=1;

        gbc.gridx=0;
        JButton a = new JButton("a");
        gblayout.setConstraints(a, gbc);
        gbc.gridx=1;
        JButton s = new JButton("s");
        gblayout.setConstraints(s, gbc);
        gbc.gridx=2;
        JButton d = new JButton("d");
        gblayout.setConstraints(d, gbc);
        gbc.gridx=3;
        JButton f = new JButton("f");
        gblayout.setConstraints(f, gbc);
        gbc.gridx=4;
        JButton g = new JButton("g");
        gblayout.setConstraints(g, gbc);
        gbc.gridx=5;
        JButton h = new JButton("h");
        gblayout.setConstraints(h, gbc);
        gbc.gridx=6;
        JButton j = new JButton("j");
        gblayout.setConstraints(j, gbc);
        gbc.gridx=7;
        JButton k = new JButton("k");
        gblayout.setConstraints(k, gbc);
        gbc.gridx=8;
        JButton l = new JButton("l");
        gblayout.setConstraints(l, gbc);


        //add keyboard line 3
        gbc.gridy=2;

        gbc.gridx=0;
        JButton confirm = new JButton("confirm");
        gblayout.setConstraints(confirm, gbc);
        gbc.gridx=1;
        JButton z = new JButton("z");
        gblayout.setConstraints(z, gbc);
        gbc.gridx=2;
        JButton x = new JButton("x");
        gblayout.setConstraints(x, gbc);
        gbc.gridx=3;
        JButton c = new JButton("c");
        gblayout.setConstraints(c, gbc);
        gbc.gridx=4;
        JButton v = new JButton("v");
        gblayout.setConstraints(v, gbc);
        gbc.gridx=5;
        JButton b = new JButton("b");
        gblayout.setConstraints(b, gbc);
        gbc.gridx=6;
        JButton n = new JButton("n");
        gblayout.setConstraints(n, gbc);
        gbc.gridx=7;
        JButton m = new JButton("m");
        gblayout.setConstraints(m, gbc);
        gbc.gridx=8;
        JButton delete = new JButton("delete");
        gblayout.setConstraints(delete, gbc);


        //put buttons in the hashmap
        this.map.put("q",q);
        this.map.put("w",w);
        this.map.put("e",e);
        this.map.put("r",r);
        this.map.put("t",t);
        this.map.put("y",y);
        this.map.put("u",u);
        this.map.put("i",i);
        this.map.put("o",o);
        this.map.put("p",p);
        this.map.put("a",a);
        this.map.put("s",s);
        this.map.put("d",d);
        this.map.put("f",f);
        this.map.put("g",g);
        this.map.put("h",h);
        this.map.put("j",j);
        this.map.put("k",k);
        this.map.put("l",l);
        this.map.put("delete",delete);
        this.map.put("z",z);
        this.map.put("x",x);
        this.map.put("c",c);
        this.map.put("v",v);
        this.map.put("b",b);
        this.map.put("n",n);
        this.map.put("m",m);
        this.map.put("confirm",confirm);

        //add listeners to buttons and set their size
        for(JButton bu : map.values()){
            this.keyboard.add(bu);
            bu.setHorizontalAlignment(JLabel.CENTER);
            if(bu==delete || bu==confirm){
                bu.setPreferredSize(new Dimension(50, 13));
            }
            else bu.setPreferredSize(new Dimension(30, 13));
            bu.addActionListener(this);
        }
    }

    /*--------------------------methods to manipulate screen-----------------------*/

    /**
     * Reset screen color to white
    */
    public void resetScreenColor(){
        for(JLabel[] line : screentext){
            for(JLabel la : line){
                la.setBackground(Color.WHITE);
            }
        }
    }

    /**
     * Clean screen text
    */
    public void resetScreenText(){
        for(JLabel[] line : screentext){
            for(JLabel la : line){
                la.setText("");
            }
        }
    }

    /**
     * Initiate screen configs
    */
    public void initScreen(){

        //initiate layout config of the screen panel
        GridBagLayout gblayout=new GridBagLayout();
        this.screen.setLayout(gblayout);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.ipadx=80;
        gbc.ipady=50;
        gbc.insets=new Insets(5, 5, 5, 5);

        //initiate all labels on the screen
        for(int out=0;out<6;out++){
            for(int in=0;in<5;in++){

                this.screentext[out][in] = new JLabel();

                gbc.gridy=out;
                gbc.gridx=in;
                gblayout.setConstraints(this.screentext[out][in], gbc);

                //set label configs
                this.screentext[out][in].setOpaque(true);
                this.screentext[out][in].setBackground(Color.WHITE);
                this.screentext[out][in].setPreferredSize(new Dimension(15, 15));
                this.screentext[out][in].setFont(new Font("Verdana", Font.PLAIN, 15));
                this.screen.add(this.screentext[out][in]);
                this.screentext[out][in].setHorizontalAlignment(JLabel.CENTER);
            }
        }
    }

    /*--------------------------methods to handle the action of button events-----------------------*/
   
    /**
     * Override actionPerformed method
     * 
     * @param e   the action event of vitural kryboard
     * 
    */
    @Override
    public void actionPerformed(ActionEvent e){
        handleCharacter(e.getActionCommand());
    }

    /**
     * Handle situations when user hit a key
     * 
     * @param newGuess   the text on the keyboard: a letter or confirm/delete
     *   
    */
    public void handleCharacter(String newGuess){

        //handle the delete situation
        if(newGuess=="delete"){
            //not the first letter
            if(this.curLocation>0){
                this.screentext[this.curAttampt][--this.curLocation].setText("");
                this.curGuess.delete(curLocation, this.curGuess.length());
            }
            //at the first letter
            if(this.curLocation==0){
                this.screentext[this.curAttampt][this.curLocation].setText("");
                this.curGuess.delete(curLocation, this.curGuess.length());
            }
        }

        //handle the confirm situation
        else if(newGuess=="confirm"){
            //not a 5 letter word
            if(this.curLocation==5){
                
                //word not in the word list
                if(!this.wordList.contains(this.curGuess.toString())){
                    //a dialog to infrom user the word is invalid
                    JOptionPane.showOptionDialog(null, "This word is not in the word list.", "Not in word list", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
                }

                //the winning situation
                else if(this.curWord.equals(this.curGuess.toString())){
                    
                    //set the backgroud to all green
                    for(JLabel la : this.screentext[this.curAttampt]){
                        la.setBackground(Color.GREEN);
                    }

                    //set dialog configs
                    JButton playAgain = new JButton("Play Again");
                    JButton exit = new JButton("Exit");
                    JButton[] buttons = {playAgain, exit};

                    playAgain.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.getRootFrame().dispose();   
				        }
                    });
		            exit.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
                            System.exit(0);
				        }
			        });
                    
                    //show dialog
		            int choice = JOptionPane.showOptionDialog(null, "You win! Play again?", "You win!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
                    
                    //if user hit play again or close the dialog, restart the game
                    if(choice==-1){
                        this.resetKeyboardColor();
                        this.resetScreenColor();
                        this.resetScreenText();
                        this.resetWord();
                        this.curAttampt=0;
                        this.curLocation=0;
                        this.curGuess.delete(0, this.curGuess.length());//reset the guess
                    }
                }

                // the user guess is not correct
                else{

                    //the final attempt is wrong, the lose situation
                    if(this.curAttampt==5){

                        //set dialog configs
                        JButton playAgain = new JButton("Play Again");
                        JButton exit = new JButton("Exit");
                        JButton[] buttons = {playAgain, exit};
                        
                        playAgain.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.getRootFrame().dispose(); 
                            }
                        });
                        exit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });

                        //show dialog
                        int choice = JOptionPane.showOptionDialog(null, "You lose, Play again?", "You lose",JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[0]);
                        
                        //if user hit play again or close the dialog, restart the game
                        if(choice==-1){
                            this.resetKeyboardColor();
                            this.resetScreenColor();
                            this.resetScreenText();
                            this.resetWord();
                            this.curAttampt=0;
                            this.curLocation=0;
                            this.curGuess.delete(0, this.curGuess.length());
                        }
                    }

                    // attampt is lower than 6, mark the labels and start another attampt
                    else{

                        //store the correct indexs
                        List<Integer> correctChar = new LinkedList<Integer>();

                        //store the wrong spot indexs
                        List<Integer> halfCorrectChar = new LinkedList<Integer>();

                        //find correct characters
                        for(int index=0;index<5;index++){
                            if(this.curGuess.charAt(index)==this.curWord.charAt(index)){
                                correctChar.add(index);
                            }
                        } 

                        //find wrong spot characters
                        for(int index=0;index<5;index++){
                            if(this.curGuess.charAt(index)!=this.curWord.charAt(index)){
                                for(int index2=0;index2<5;index2++){
                                    if(this.curGuess.charAt(index)==this.curWord.charAt(index2) && index!=index2 && !correctChar.contains(index2)){//exclude the right indexs
                                        halfCorrectChar.add(index);
                                    }
                                }
                            }
                        }

                        //find wrong characters and mark them to grey
                        for(int index=0;index<5;index++){
                            if(!correctChar.contains(index) && !halfCorrectChar.contains(index)){
                                this.screentext[this.curAttampt][index].setBackground(Color.GRAY);
                                map.get(this.screentext[this.curAttampt][index].getText()).setBackground(Color.GRAY);
                            }
                        }

                        //mark screen and keyboard colors to give feedback
                        for(int index : halfCorrectChar){
                            this.screentext[this.curAttampt][index].setBackground(Color.YELLOW);
                            map.get(this.screentext[this.curAttampt][index].getText()).setBackground(Color.YELLOW);
                        }
                        for(int index : correctChar){
                            this.screentext[this.curAttampt][index].setBackground(Color.GREEN);
                            map.get(this.screentext[this.curAttampt][index].getText()).setBackground(Color.GREEN);
                        }

                        //start another attampt
                        this.curAttampt++;
                        this.curLocation=0;
                        this.curGuess.delete(0, this.curGuess.length());
                    }
                }
            }
            //entered a none-5-letter word
            else{
                JOptionPane.showOptionDialog(null, "Please enter a 5 letter word.", "Not 5 characters", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
            }
        }

        //update the user guess
        else if(this.curAttampt <= 5 && this.curLocation <= 4){
            this.screentext[this.curAttampt][this.curLocation++].setText(newGuess);
            this.curGuess.append(newGuess);
        }
    }

    
    /*--------------------------methods relate to guess-----------------------*/

    /**
     * Load the word list from word.txt
     */
    public void loadWord(){
        try{
            FileReader fr = new FileReader("word.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                this.wordList.add(line);
                line = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println("Error occurs when reading the file");
            System.exit(1);
        }
        
    }

    /**
     * Reset a random word in the word list
     */
    public void resetWord(){
        Random random = new Random();
        int index = random.nextInt(this.wordList.size());
        this.curWord = this.wordList.get(index);
        
        //show the answer on command line to help debug
        //System.out.println(this.curWord);
    }
}
