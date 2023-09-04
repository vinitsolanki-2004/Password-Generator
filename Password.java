import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Password extends JFrame implements ActionListener {
    JFrame pframe;
    JLabel password, num, splchar,genpass;
    JTextField num_char;
    JTextArea gen_password;
    JRadioButton yes, no;
    ButtonGroup spl_char;
    JButton generate;
    Container c;
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    public Password(){
        setTitle("Password Generator");
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        c =getContentPane();
        c.setBackground(Color.BLACK);

        password = new JLabel("Password Generator");
        password.setFont(new Font("Arial",Font.BOLD,30));
        password.setSize(500,30);
        password.setLocation(100,50);
        password.setForeground(Color.yellow);
        c.add(password);

        num = new JLabel("Enter number of Characters :");
        num.setFont(new Font("Arial",Font.PLAIN,20));
        num.setSize(300,20);
        num.setLocation(20,150);
        num.setForeground(Color.yellow);
        c.add(num);

        num_char = new JTextField();
        num_char.setSize(50,25);
        num_char.setLocation(290,150);
        c.add(num_char);

        splchar = new JLabel("Include Special Character : ");
        splchar.setFont(new Font("Arial",Font.PLAIN,20));
        splchar.setSize(300,20);
        splchar.setLocation(20,200);
        splchar.setForeground(Color.yellow);
        c.add(splchar);

        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Arial",Font.PLAIN,20));
        yes.setSize(80,20);
        yes.setLocation(290,200);
        yes.setForeground(Color.yellow);
        c.add(yes);

        no = new JRadioButton("No");
        no.setFont(new Font("Arial",Font.PLAIN,20));
        no.setSize(80,20);
        no.setLocation(370,200);
        no.setForeground(Color.yellow);
        c.add(no);

        spl_char = new ButtonGroup();
        spl_char.add(yes);
        spl_char.add(no);

        generate = new JButton("Generate Password");
        generate.setBounds(90,280,300,30);
        generate.setFont(new Font("Arial",Font.BOLD,25));
        generate.setBorderPainted(false);
        generate.setBackground(Color.yellow);
        generate.setOpaque(true);
        generate.addActionListener(this);
        c.add(generate);

        genpass = new JLabel("Password :");
        genpass.setFont(new Font("Arial",Font.PLAIN,20));
        genpass.setSize(300,20);
        genpass.setLocation(20,350);
        genpass.setForeground(Color.yellow);
        c.add(genpass);

        gen_password = new JTextArea();
        gen_password.setBounds(150,347,200,25);
        gen_password.setFont(new Font("Arial",Font.PLAIN,20));
        gen_password.setEditable(false);
        gen_password.setBackground(Color.gray);
        gen_password.setForeground(Color.black);
        gen_password.setOpaque(true);
        c.add(gen_password);

        setVisible(true);

    }

    public static void main(String []args){
        new Password();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(generate)) {
            int length = Integer.valueOf(num_char.getText());

            String str = generatePassword(length);
            gen_password.setText(str);
        }
    }
    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        String allCharacters;

        if(yes.isSelected())
            allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

        else allCharacters = LOWERCASE + UPPERCASE + DIGITS;

        Random random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }

        return password.toString();
    }

}
