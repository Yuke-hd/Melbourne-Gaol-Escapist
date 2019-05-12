package model.skills;

import model.player.A47;
import model.player.Guard;
import model.player.Havoc;
import model.player.Jager;
import model.player.LawEnforcer;
import model.player.LockSmith;
import model.player.Warden;

public class ArrestVisitor implements SkillVisitor{

	public ArrestVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitPlayer(Havoc havoc) {
	}

	@Override
	public void visitPlayer(Jager jager) {
	}

	@Override
	public void visitPlayer(A47 a47) {
	}

	@Override
	public void visitPlayer(LockSmith locksmith) {
	}

	@Override
	public void visitPlayer(Warden warden) {
		arrest(warden);
	}

	@Override
	public void visitPlayer(Guard guard) {
		arrest(guard);
	}
	
	private void arrest(LawEnforcer player) {
		System.out.println("arrest");
	}

}
