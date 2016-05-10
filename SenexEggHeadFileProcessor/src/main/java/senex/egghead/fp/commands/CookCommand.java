package senex.egghead.fp.commands;

import org.springframework.stereotype.Component;

import senex.commands.SenexCommandBase;
import senex.core.Senex;
import senex.core.SenexCommand;

@SenexCommand(name = "cook")
@Component
public class CookCommand extends SenexCommandBase {
	@Override
	public void execute() throws Exception {
		Senex.out.println("I am gonna cook all data");
	}
}
