package model.skills;

import model.player.A47;
import model.player.Guard;
import model.player.Havoc;
import model.player.Jager;
import model.player.LockSmith;
import model.player.Warden;

public class PlaceTrapVisitor implements SkillVisitor {

	public PlaceTrapVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitPlayer(Havoc havoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPlayer(Jager jager) {
		placeTrap();

	}

	private void placeTrap() {
		System.out.println("palce trap");
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
