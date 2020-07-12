package mbs.server.frame.strategy;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import mbs.cdi.BeansContext;
import mbs.frame.strategy.FrameStrategy;
import mbs.frame.strategy.Frames;
import mbs.protocol.ConverterData;
import mbs.protocol.Protocol;
import mbs.protocol.ProtocolBuilder;
import mbs.protocol.ProtocolBuilderHelper;
import mbs.protocol.data.DataSimple;
import mbs.service.DataHourService;



public class RequestDataHourFrameStrategyImpl implements FrameStrategy {

	private static Logger LOG = Logger.getLogger(RequestDataHourFrameStrategyImpl.class);
	private DataHourService dataHourService = (DataHourService) BeansContext.getInstance().getService(DataHourService.class);
	private ProtocolBuilderHelper helper = new ProtocolBuilderHelper();
	
	@Override
	public Protocol executeStrategy(Protocol protocol) throws Exception {

		
		DataSimple  dataSimple = new ConverterData().toDataSimple(protocol);
		LOG.info("------------------------------------------------------------------------");
		LOG.info("\t\tDADOS RECEBIDOS: " + dataSimple.toString());
		LOG.info("------------------------------------------------------------------------");
		
		Date date = dataHourService.getDataFromLocal(dataSimple.getData());
		
		Calendar.getInstance().setTime(date);	
		
		 
		StringBuffer dataToSend =  new StringBuffer();
		dataToSend.append(helper.toHexString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
		dataToSend.append(helper.toHexString(Calendar.getInstance().get(Calendar.MONTH) +1));
		dataToSend.append(helper.toHexString(Calendar.getInstance().get(Calendar.YEAR) % 100));
		dataToSend.append(helper.toHexString(Calendar.getInstance().get(Calendar.HOUR)));
		dataToSend.append(helper.toHexString(Calendar.getInstance().get(Calendar.MINUTE)));
		dataToSend.append(helper.toHexString(Calendar.getInstance().get(Calendar.SECOND)));		
		
		return new ProtocolBuilder.Builder().
				addByte("0B").
				addData(dataToSend.toString()).
				addCrc("FE").
				addFrame(Frames.RequestDataHour.getFrame()).
				builderProtocol();
	}

}
