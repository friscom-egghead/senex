package senex.commands;

import org.springframework.stereotype.Component;

import senex.core.Senex;
import senex.core.SenexCommand;

@SenexCommand(name="about")
@Component(value = "aboutCommands")
public class AboutCommands extends SenexCommandBase {
	private static final String COMMAND_SYNTAX = "USAGE SYNTAX: senex (command1 command2 ...) [options]";

	@Override
	public void init() {
		super.init();
		Senex.logInfo(logger, "AboutCommandInit", "message", "Senex Application Framework.");
	}
	
	@Override
	public void execute() throws Exception {
		Senex.logInfo(logger, "AboutCommandExecution", "message", "Senex Application Framework.");		
		Senex.out.println(
				"------------------------------------Welcome to Senex Shell------------------------------------"
					);
		Senex.out.println(COMMAND_SYNTAX);
		Senex.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	
	@Override
	public void cleanUp() {
		super.cleanUp();
		Senex.logInfo(logger, "AboutCommandCleanUp", "message", "Senex Application Framework.");
	}

}
