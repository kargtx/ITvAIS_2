import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        new EnterF();
    }
}


//класс графики пользовательского окна и ввода/вывода данных
class EnterF extends JFrame {
    //создание переменных
    int b = 1;
    double x1 = -5;
    double x2 = 5;

    //создание текстовых полей
    TextField Tx1;
    TextField Tx2;
    TextField Tf;
    //создание окна
    JFrame JF;
    JPanel JP;
    JButton bt, bt2;
    JLabel answ;
    Font font = new Font("default", Font.BOLD, 15);

    EnterF() {
        //dsjfkjdsjfksd
    }
}