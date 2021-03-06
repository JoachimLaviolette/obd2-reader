package fr.obd2Reader.command.pressure;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import fr.obd2Reader.command.CompatibleCommand;

public class EvaporationSystemVaporPressureCommand extends PressureCommand implements CompatibleCommand{
	
	public EvaporationSystemVaporPressureCommand(OutputStream out, InputStream in){
		super("01 32", "Evaporation System Pressure", out, in);
		setUnit("Pa");
	}
	
	public void compute(){
		sendCommand();
		read();
		setData(((getInBuff().get(0)*256) + getInBuff().get(1))/4);
	}

	@Override
	public boolean isCompatible(ArrayList<Byte> vehicleRef) {
		
		return false;
	}

	public String getPressure() {
		// TODO Auto-generated method stub
		return null;
	}

}
