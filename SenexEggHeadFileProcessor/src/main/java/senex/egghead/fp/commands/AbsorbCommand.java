package senex.egghead.fp.commands;

import org.springframework.stereotype.Component;

import senex.commands.SenexCommandBase;
import senex.core.Senex;
import senex.core.SenexCommand;

@SenexCommand(name = "absorb")
@Component
public class AbsorbCommand extends SenexCommandBase {
	@Override
	public void execute() throws Exception {
		Senex.out.println("I am gonna absorb all data");
	}
}
