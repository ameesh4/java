import javax.swing.*;

class MenuBar{
    JMenuBar mb;
    JMenu menu;
    JMenuItem item;
    JMenu submenu;

    MenuBar(JMenuBar mb){
        this.mb = mb;
    }

    public MenuBar setMenuItem(String s){
        this.item = new JMenuItem(s);
        this.menu.add(this.item);
        return this;
    }

    public MenuBar setMenuItem(String s, boolean separator){
        this.item = new JMenuItem(s);
        if (separator){
            this.menu.addSeparator();
        }
        this.menu.add(this.item);
        return this;
    }

    public MenuBar addMenu(String s){
        this.menu = new JMenu(s);
        this.mb.add(this.menu);
        return this;
    }

    public MenuBar setMenuItem(MenuBar m){
        this.item = m.menu;
        this.menu.add(this.item);
        return this;
    }
    
    public JMenuBar getMenuBar(){
        return mb;
    }
}

public class JavaSwingcw {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Bar");
        frame.setSize(400, 400);
        MenuBar mb = new MenuBar(new JMenuBar());
        mb.addMenu("File")
            .setMenuItem("save")
            .setMenuItem("save as")
            .setMenuItem("exit", true);

        MenuBar sb = new MenuBar(new JMenuBar());
        mb.addMenu("Edit")
            .setMenuItem(
                new MenuBar(new JMenuBar()).addMenu("Layout")
                    .setMenuItem("Bold", true)
                    .setMenuItem("Italic", true)
                    .setMenuItem("", true)
                    .setMenuItem("Undefined", true)
            );


        frame.setJMenuBar(mb.getMenuBar());
        frame.setVisible(true);
        frame.setLayout(null);
    }
}