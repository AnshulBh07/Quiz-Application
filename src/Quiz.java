import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class Score extends JFrame implements KeyListener,MouseListener{

    JButton b;
    Score(String username,int score){
        setBounds(400, 200, 900, 600);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        JLabel l1 = new JLabel("Congratulations,");
        l1.setFont(new Font("Dialog", Font.BOLD, 20));
        l1.setForeground(Color.green);
        l1.setBackground(Color.black);
        l1.setBounds(100, 150, 600, 40);
        add(l1);

        JLabel l2 = new JLabel(username);
        l2.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        l2.setForeground(Color.green);
        l2.setBackground(Color.black);
        l2.setBounds(280, 150, 600, 40);
        add(l2);

        JLabel l3 = new JLabel(",You have completed the quiz!");
        l3.setFont(new Font("Dialog", Font.BOLD, 20));
        l3.setForeground(Color.green);
        l3.setBackground(Color.black);
        l3.setBounds(500, 150, 600, 40);
        add(l3);

        JLabel l4 = new JLabel("Your Score is\n ");
        l4.setFont(new Font("Dialog", Font.BOLD, 30));
        l4.setForeground(Color.green);
        l4.setBackground(Color.black);
        l4.setBounds(340, 220, 600, 40);
        add(l4);

        JLabel l5 = new JLabel( "" + score);
        l5.setFont(new Font("Viner Hand ITC", Font.BOLD, 100));
        l5.setForeground(Color.green);
        l5.setBackground(Color.black);
        l5.setBounds(400, 300, 600, 100);
        add(l5);

        b = new JButton("Play Again");
        b.setFont(new Font("Dialog", Font.BOLD, 20));
        b.setBounds(650, 420, 150, 55);
        b.setBackground(Color.blue);
        b.setForeground(Color.white);
        b.addKeyListener(this);
        b.addMouseListener(this);
        add(b);

        setVisible(true);
        setDefaultCloseOperation(3);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            this.setVisible(false);
            new Quiz().setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == b)
        {
            this.setVisible(false);
            new Quiz().setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class Questions extends JFrame implements ActionListener{

    JLabel qno, ques;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton GS,Next;
    ButtonGroup options;
    public static int count =0;
    public static int score =0;
    String[][] q = new String[3][5];
    String[][] stuAns = new String[3][1];
    String[][] correct = new String[3][2];
    String username;

    Questions(String username){
        this.username = username;
        setBounds(400, 200, 900, 600);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(3);
        setLayout(null);
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        JLabel l = new JLabel(im);
        l.setBounds(0, 0, 900, 200);
        add(l);

        qno = new JLabel("");
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        qno.setForeground(Color.white);
        qno.setBounds(50,200,30,60);
        add(qno);

        ques = new JLabel("");
        ques.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ques.setForeground(Color.white);
        ques.setBounds(100,200,800,60);
        add(ques);

        opt1 = new JRadioButton("");
        opt1.setBounds(100, 280, 350, 50);
        opt1.setBackground(Color.darkGray);
        opt1.setForeground(Color.white);
        opt1.setFont(new Font("Dialog", Font.BOLD, 20));
        opt1.addActionListener(this);
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setBounds(450, 280, 350, 50);
        opt2.setBackground(Color.darkGray);
        opt2.setForeground(Color.white);
        opt2.setFont(new Font("Dialog", Font.BOLD, 20));
        opt2.addActionListener(this);
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setBounds(100, 380, 350, 50);
        opt3.setBackground(Color.darkGray);
        opt3.setForeground(Color.white);
        opt3.setFont(new Font("Dialog", Font.BOLD, 20));
        opt3.addActionListener(this);
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setBounds(450, 380, 350, 50);
        opt4.setBackground(Color.darkGray);
        opt4.setForeground(Color.white);
        opt4.setFont(new Font("Dialog", Font.BOLD, 20));
        opt4.addActionListener(this);
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        Next = new JButton("Next");
        Next.setBounds(730, 470, 100, 40);
        Next.setBackground(Color.blue);
        Next.setForeground(Color.WHITE);
        Next.setFont(new Font("Dialog", Font.BOLD, 20));
        Next.addActionListener(this);
        add(Next);

        q[0][0] = "Which of the following is not a java feature?";
        q[0][1] = "Object-Oriented";
        q[0][2] = "Use of pointers";
        q[0][3] = "Architecture Neutral";
        q[0][4] = "Dynamic";

        q[1][0] = "_______ is used to fix bugs in Java programs.";
        q[1][1] = "JVM";
        q[1][2] = "JRE";
        q[1][3] = "JDK";
        q[1][4] = "JDB";

        q[2][0] = "How many threads can be executed at a time?";
        q[2][1] = "Only one thread";
        q[2][2] = "Only main(main() method) thread";
        q[2][3] = "Multiple threads";
        q[2][4] = "Two threads";

        correct[0][1] = "Use of pointers";
        correct[1][1] = "JDB";
        correct[2][1] = "Multiple threads";

        setVisible(true);
        update(0);

    }

    //update questions
    public void update(int count){
        qno.setText(""+(count+1)+".");
        ques.setText(q[count][0]);
        opt1.setText(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setText(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setText(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setText(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Next)
        {
            repaint();
            if(options.getSelection() == null)
            {
                stuAns[count][0] = "";
            }
            else{
                stuAns[count][0] = options.getSelection().getActionCommand();
            }
            count++;
            update(count);
        }
        else if(e.getSource() == GS){
            if(options.getSelection() == null)
            {
                stuAns[count][0] = "";
            }
            else{
                stuAns[count][0] = options.getSelection().getActionCommand();
            }
            for(int i=0;i<stuAns.length;i++)
            {
                if(stuAns[i][0].equals(correct[i][1]))
                    score+=5;
            }
            new Score(username,score).setVisible(true);
            this.setVisible(false);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        if(count == q.length-1)
        {
            Next.setVisible(false);
            GS = new JButton("Get Score");
            GS.setBounds(700, 470, 150, 40);
            GS.setBackground(Color.blue);
            GS.setForeground(Color.WHITE);
            GS.setFont(new Font("Dialog", Font.BOLD, 20));
            GS.addActionListener(this);
            add(GS);
        }
    }
}

public class Quiz extends JFrame implements ActionListener, MouseListener{

    JButton Submit;
    JTextField tf;
    JLabel l1,l2,l3;

    Quiz(){
        setTitle("Quiz");
        setBounds(400,200, 1200, 600);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(3);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz_time.jpg"));
        l1 = new JLabel(i1);
        l1.setBounds(0,0,600,600);
        add(l1);

        setVisible(true);

        l2 = new JLabel("Test Your Knowledge!");
        l2.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        l2.setBackground(Color.black);
        l2.setForeground(Color.cyan);
        l2.setBounds(720, 180, 500, 43);
        add(l2);

        //label that appears on mouse hover
        l3 = new JLabel("Submit and proceed to the quiz!");
        l3.setFont(new Font("Dialog", Font.BOLD, 20));
        l3.setBackground(Color.black);
        l3.setForeground(Color.cyan);
        l3.setBounds(650, 500, 500, 40);
        add(l3);
        l3.setVisible(false);

        tf = new JTextField();
        tf.setBounds(760, 250, 250, 35);
        add(tf);

        Submit = new JButton("Submit");
        Submit.setBounds(835, 300, 100, 35);
        Submit.setBackground(Color.blue);
        Submit.setForeground(Color.white);

        Submit.addActionListener(this);
        Submit.addMouseListener(this);
        add(Submit);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Submit)
        {
            String name = tf.getText();
            this.setVisible(false);
            new Questions(name).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Quiz();
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == Submit)
        {
            l3.setVisible(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == Submit){
            l3.setVisible(false);
        }
    }

}