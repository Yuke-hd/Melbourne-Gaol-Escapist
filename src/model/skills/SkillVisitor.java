package model.skills;

import model.player.A47;
import model.player.Guard;
import model.player.Havoc;
import model.player.Jager;
import model.player.LockSmith;
import model.player.Warden;

public interface SkillVisitor {

	void visitPlayer(Havoc havoc);

	void visitPlayer(Jager jager);

	void visitPlayer(A47 a47);

	void visitPlayer(LockSmith locksmith);

	void visitPlayer(Warden warden);

	void visitPlayer(Guard guard);
}
