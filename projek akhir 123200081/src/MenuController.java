import view.LihatViewKelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    MenuView mv;

    public MenuController(MenuView menuView) {
        this.mv = menuView;

        // lihat data ==========================================================
        menuView.btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LihatView lihatView = new LihatView();
                LihatModel lihatModel = new LihatModel();
                new LihatController(lihatView, lihatModel);
            }
        });

        menuView.btnLihatKelas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LihatViewKelas lihatView = new LihatViewKelas();
                LihatModel lihatModel = new LihatModel();
                new LihatController(lihatView, lihatModel);
            }
        });



    }

}
