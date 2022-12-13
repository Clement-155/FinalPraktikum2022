/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject_155.menu;

import javax.swing.JFrame;

/**
 *
 * @author Christopher Clement
 * @param <S>
 */
public interface SwingApp <S extends JFrame> {
    public void gameRun(final S ex);
    public void gameClose(final S ex);
}
