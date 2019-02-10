package ComponentsTest;

import java.awt.event.*;

// этот класс будет получать извещения о событиях
class KeyL implements KeyListener {
    // печать символа
    public void keyTyped(KeyEvent k) {
        System.out.println(k);
    }

    // нажатие клавиши
    public void keyPressed(KeyEvent k) {
        System.out.println(k);
    }

    // отпускание нажатой клавиши
    public void keyReleased(KeyEvent k) {
        System.out.println(k);
    }
}