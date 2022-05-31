
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author hp
 */
public class Controller {

    Model model;
    View view;
    public String dataterpilih;

    Controller(Model mm, View vw) {
        this.model = mm;
        this.view = vw;

        if (model.getBanyakData() != 0) {
            String dataaslab[][] = model.daftaraslab();
            view.tabel.setModel((new JTable(dataaslab, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.btnTambah.addActionListener(ae -> {
            String nama = view.getNama();
            String portofolio = view.getPortofolio();
            String microteaching = view.getMicroteaching();
            String wawancara = view.getWawancara();
            model.insertAslab(nama, portofolio, microteaching, wawancara);

            String dataaslab[][] = model.daftaraslab();
            view.tabel.setModel((new JTable(dataaslab, view.namaKolom)).getModel());
        });

        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = view.getNama();
                String portofolio = view.getPortofolio();
                String microteaching = view.getMicroteaching();
                String wawancara = view.getWawancara();
                model.updateAslab(nama, portofolio, microteaching, wawancara);

                String dataaslab[][] = model.daftaraslab();
                view.tabel.setModel((new JTable(dataaslab, view.namaKolom)).getModel());
            }
        });

        view.tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = view.tabel.getSelectedRow();

                dataterpilih = view.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);

            }

        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Data Aslab " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deleteAslab(dataterpilih);
                    String dataaslab[][] = model.daftaraslab();
                    view.tabel.setModel((new JTable(dataaslab, view.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }

}
