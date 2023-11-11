import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textFeld;

    JButton[] Nummern = new JButton[10];
    JButton[] Funktionen = new JButton[8];

    JButton plus, minus, mal, geteilt;
    JButton dezimal, gleich, löschen, neu;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.ITALIC,25);

    double num1=0, num2=0, result=0;
    char operator;



    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textFeld = new JTextField();
        textFeld.setBounds(50, 25, 300, 50);
        textFeld.setFont(myFont);
        textFeld.setEditable(false);

        plus = new JButton("+");
        minus = new JButton("-");
        mal = new JButton("X");
        geteilt = new JButton(":");
        gleich = new JButton("=");
        dezimal = new JButton(".");
        löschen = new JButton("Löschen");
        neu = new JButton("neu");

        Funktionen[0] = plus;
        Funktionen[1] = minus;
        Funktionen[2] = mal;
        Funktionen[3] = geteilt;
        Funktionen[4] = gleich;
        Funktionen[5] = dezimal;
        Funktionen[6] = löschen;
        Funktionen[7] = neu;

        for (int i=0;i<8;i++){
            Funktionen[i].addActionListener(this);
            Funktionen[i].setFont(myFont);
            Funktionen[i].setFocusable(false);
        }

        for (int i=0;i<10;i++){
            Nummern[i]= new JButton(String.valueOf(i));
            Nummern[i].addActionListener(this);
            Nummern[i].setFont(myFont);
            Nummern[i].setFocusable(false);
        }

        löschen.setBounds(50,430,145,50);

        neu.setBounds(200,430,145,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        

        panel.add(Nummern[1]);
        panel.add(Nummern[2]);
        panel.add(Nummern[3]);
        panel.add(plus);
        panel.add(Nummern[4]);
        panel.add(Nummern[5]);
        panel.add(Nummern[6]);
        panel.add(minus);
        panel.add(Nummern[7]);
        panel.add(Nummern[8]);
        panel.add(Nummern[9]);
        panel.add(mal);
        panel.add(dezimal);
        panel.add(Nummern[0]);
        panel.add(gleich);
        panel.add(geteilt);

        frame.add(panel);
        frame.add(neu);
        frame.add(löschen);
        frame.add(textFeld);
        frame.setVisible(true);





        JButton addButton = new JButton("+");

        frame.add(textFeld);

        frame.setVisible(true);

        

    }
    public static void main(String[] args) {

        Calculator calc =  new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<10; i++) {
            if (e.getSource() == Nummern[i]){
                textFeld.setText(textFeld.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dezimal) {
            textFeld.setText(textFeld.getText().concat("."));
        }
        if (e.getSource() == plus) {
            num1 = Double.parseDouble(textFeld.getText());
            operator = '+';
            textFeld.setText("");
        }
        if (e.getSource() == minus) {
            num1 = Double.parseDouble(textFeld.getText());
            operator = '-';
            textFeld.setText("");
        }
        if (e.getSource() == mal) {
            num1 = Double.parseDouble(textFeld.getText());
            operator = 'X';
            textFeld.setText("");
        }
        if (e.getSource() == geteilt) {
            num1 = Double.parseDouble(textFeld.getText());
            operator = ':';
            textFeld.setText("");
        }

        if (e.getSource() == gleich) {
            num2=Double.parseDouble(textFeld.getText());

            switch (operator){
                case'+':
                    result = num1 + num2;
                    break;

                case'-':
                    result = num1 - num2;
                    break;

                case'X':
                    result = num1 * num2;
                    break;

                case':':
                    result = num1 / num2;
                    break;
            }
            textFeld.setText(String.valueOf(result));
            num1=result;
            }

        if (e.getSource()==neu) {
            textFeld.setText("");
        }

        if (e.getSource()==löschen) {
            String string = textFeld.getText();
            textFeld.setText("");
            for (int i=0;i<string.length()-1;i++){
                textFeld.setText(textFeld.getText()+string.charAt(i));
            }
        }
    }
}