package model.skills;

import controller.GameControl;
import model.DIR;
import model.Position;
import model.player.A47;
import model.player.Guard;
import model.player.Havoc;
import model.player.Jager;
import model.player.LockSmith;
import model.player.Warden;

public class BreakWallVisitor implements SkillVisitor {

	public BreakWallVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitPlayer(Havoc havoc) {
		breakWall(havoc);

	}

	private void breakWall(Havoc havoc) {
		int wall[] = GameControl.wall;
		DIR facingDir = havoc.getFacing();
		Position pos;
		int seq=0;
		System.out.println("break wall");
		havoc.getPos();
		int x = havoc.getPos().getX();
		int y = havoc.getPos().getY();

		switch (facingDir) {
		case up:
			pos = new Position(x, y - 1);
			seq = pos.getSeq();
			break;
		case down:
			pos = new Position(x, y + 1);
			seq = pos.getSeq();
			break;
		case left:
			pos = new Position(x - 1, y);
			seq = pos.getSeq();
			break;
		case right:
			pos = new Position(x + 1, y);
			seq = pos.getSeq();
			break;
		default:
			break;
		}

		for (int i = 0; i < wall.length; i++) {
			if (seq == wall[i]) {
				System.out.println("wall: " + seq);
				wall[i] = 0;
			}
		}
	}

	@Override
	public void visitPlayer(Jager jager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPlayer(A47 a47) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPlayer(LockSmith locksmith) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPlayer(Warden warden) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPlayer(Guard guard) {
		// TODO Auto-generated method stub

	}

}
