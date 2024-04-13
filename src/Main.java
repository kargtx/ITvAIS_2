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
    double b = 1;
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
        //создание окна с настройками и полей ввода
        JF = new JFrame();
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JP = new JPanel();
        JF.add(JP);
        JP.setBackground(Color.YELLOW);
        JP.setLayout(null);
        JF.setSize(540, 350);
        JF.setTitle("ИТвАИС ЛР 2");

        //создание надписей
        JLabel Lf = new JLabel("Стоимость 1 киловатта-часа:");
        JLabel Lx1 = new JLabel("Старое значение счетчика:");
        JLabel Lx2 = new JLabel("Новое значение счетчика:");

        //задание координат и начальных значений для текстовых полей и кнопок
        //текстовое поле для кВ*ч
        Tf = new TextField("4.01");
        Tf.setLocation(220, 20);
        Tf.setSize(50, 20);
        JP.add(Tf);

        //текстовое поле для старого значения счетчика
        Tx1 = new TextField("0", 40);
        Tx1.setLocation(220, 60);
        Tx1.setSize(50, 20);
        JP.add(Tx1);

        //текстовое поле для нового значения счетчика
        Tx2 = new TextField("0", 40);
        Tx2.setLocation(220, 100);
        Tx2.setSize(50, 20);
        JP.add(Tx2);

        //текст кВ*ч
        Lf.setLocation(20, 20);
        Lf.setSize(200, 20);
        JP.add(Lf);

        //текст старого
        Lx1.setLocation(20, 60);
        Lx1.setSize(400, 20);
        JP.add(Lx1);

        //текст нового
        Lx2.setLocation(20, 100);
        Lx2.setSize(400, 20);
        JP.add(Lx2);

        //кнопка расчета
        bt = new JButton("Расчитать");
        bt.setLocation(80, 180);
        bt.setSize(150, 50);
        JP.add(bt);

        //кнопка сохранения
        bt2 = new JButton("Сохранить");
        bt2.setLocation(310, 180);
        bt2.setSize(150, 50);
        JP.add(bt2);
        bt2.setVisible(false);

        //текст ответа
        answ = new JLabel("");
        answ.setLocation(10, 250);
        answ.setSize(500, 20);
        JP.add(answ);
        answ.setFont(font);

        JF.setVisible(true);
        JF.setResizable(false);

        //кнопка расчета
        bt.addActionListener
                (
                        //тут проверка корректности ввода и значений и запуск расчета
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                try
                                {
                                    //считывание значений из полей
                                    b = Double.valueOf(Tf.getText());
                                    x1 = Double.valueOf(Tx1.getText());
                                    x2 = Double.valueOf(Tx2.getText());
                                    if (x1 < 0)
                                    {
                                        set("Ошибка! Минимальное значение счетчика 0");
                                        return;
                                    }
                                    if (b <= 0)
                                    {
                                        set("Ошибка! Электроэнергия не может быть <= 0");
                                        return;
                                    }

                                    if (x1 < x2)
                                    {
                                        try
                                        {
                                            //расчеты и вывод ответа
                                            set("К оплате по счету за электроэнергию: " + String.valueOf(calc(b, x1, x2)) + " у.е.");
                                            //делаем кнопку видимой
                                            bt2.setVisible(true);

                                        }
                                        catch (Exception w3)
                                        {
                                            set("Ошибка");
                                            System.out.println(w3);
                                        }
                                    }
                                    else
                                    {
                                        set("Ошибка! Некорректные значения");
                                    }
                                }
                                catch (Exception e1)
                                {
                                    set("Ошибка! Некорректный формат данных");
                                }
                            }
                        }
                );
        //кнопка сохранения
        bt2.addActionListener
                (
                        //сохраняем значения
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                //меняем значение текстовых полей
                                Tx1.setText(Tx2.getText());
                                Tx2.setText("");
                            }
                        }
                );
    }

    //расчитываем стоимость израсходованной электроэнергии
    double calc(double b, double x1, double x2)
    {
        return (x2 - x1) * b;
    }

    //вывод ответа в грвфический интерфейс пользователя
    void set(String s)
    {
        answ.setText(s);
    }

}
