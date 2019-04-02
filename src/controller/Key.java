package controller;

import java.awt.event.KeyEvent;

public class Key {

	public Key() {
		// TODO Auto-generated constructor stub
	}

	public void keyPressed(KeyEvent e) { // 按键被按下时被触发

		String keyText = KeyEvent.getKeyText(e.getKeyCode());// 获得描述keyCode的标签
		if (e.isActionKey()) { // 判断按下的是否为动作键

			System.out.println("您按下的是动作键“" + keyText + "”");

		} else {

			System.out.print("您按下的是非动作键“" + keyText + "”");
			int keyCode = e.getKeyCode();// 获得与此事件中的键相关联的字符

			switch (keyCode) {
			case KeyEvent.VK_CONTROL: // 判断按下的是否为Ctrl键
				System.out.print("，Ctrl键被按下");
				break;
			case KeyEvent.VK_ALT: // 判断按下的是否为Alt键
				System.out.print("，Alt键被按下");
				break;
			case KeyEvent.VK_SHIFT: // 判断按下的是否为Shift键
				System.out.print("，Shift键被按下");
				break;
			}
			System.out.println();
		}
	}

}
