
package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {

    JLabel lJudul = new JLabel("Cuboid Calculator");
    JLabel lLength = new JLabel("Length :");
    JLabel lWidth = new JLabel("Width   :");
    JLabel lHeight = new JLabel("Height   :");


    JTextField tfLength = new JTextField();
    JTextField tfWidth = new JTextField();
    JTextField tfHeight = new JTextField();

    JButton btnCount = new JButton("Count");
    JButton btnReset = new JButton("Reset");

    public Gui() {

        setTitle("Cuboid Calculator");
        setSize(400,500);
        setLayout(null);

        add(lJudul);
        add(lLength);
        add(lWidth);
        add(lHeight);
        add(tfHeight);
        add(tfLength);
        add(tfWidth);
        add(btnCount);
        add(btnReset);

        lJudul.setBounds(125,10,200,20);

        lLength.setBounds(20,70,100,20);
        tfLength.setBounds(130,70,100,20);

        lHeight.setBounds(20,100,100,20);
        tfHeight.setBounds(130,100,100,20);

        lWidth.setBounds(20,130,100,20);
        tfWidth.setBounds(130,130,100,20);

        btnCount.setBounds(100,220,75,20);
        btnReset.setBounds(180,220,75,20);





        btnCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {






                String length = tfLength.getText().toString();
                double Length = Double.parseDouble(length);
                String width = tfWidth.getText().toString();
                double Width = Double.parseDouble(width);
                String height = tfHeight.getText().toString();
                double Height = Double.parseDouble(height);
                PersegiPanjang pp = new PersegiPanjang(Length,Width);
                Balok balok = new Balok(Length,Width,Height);
                double luas = pp.hitungLuas();
                double keliling = pp.hitungKeliling();
                double luasPermukaan = balok.hitungLuas();
                double volume = balok.hitungVolume();

                String sLuas=String.valueOf(luas);
                String sKeliling=String.valueOf(keliling);
                String sluasPermukaan=String.valueOf(luasPermukaan);
                String sVolume=String.valueOf(volume);



                JLabel lLuas = new JLabel("Luas : " + sLuas);
                JLabel lKeliling = new JLabel("Keliling : " + sKeliling);
                JLabel lLuasPermukaan = new JLabel("Luas Permukaan : " + sluasPermukaan);
                JLabel lVolume = new JLabel("Volume : " + sVolume);

                add(lLuas);
                add(lKeliling);
                add(lLuasPermukaan);
                add(lVolume);

                lLuas.setBounds(130,270,100,20);
                lKeliling.setBounds(130,300,100,20);
                lLuasPermukaan.setBounds(130,330,200,20);
                lVolume.setBounds(130,360,360,20);

            }
        });


        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                tfLength.setText("");
                tfWidth.setText("");
                tfHeight.setText("");

            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
