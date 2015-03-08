//Carl Testa 2014-2015

BusToOSC {

	var <>netAddr; //an instance of NetAddr
    var <>bus; //an instance of Bus (single channel)
	var <>message; //OSC message to send text or otherwise
	var <>update; //update frequency
	var <>multiplier;
	var rout;

	*new {arg netAddr = nil, bus = nil, message = "/test", update = 0.04, multiplier = 1;
		^super.new.init(netAddr, bus, message, update, multiplier)
	}

	init { arg aNetAddr, aBus, aMessage, anUpdate, aMultiplier;

		netAddr = aNetAddr;
		bus = aBus;
		message = aMessage;
		update = anUpdate;
		multiplier = aMultiplier;

		rout = Routine.new({ loop {
			update.wait;
			bus.get({|v|
			netAddr.sendMsg(message, v*multiplier);
			});
            }
		}).play;
	}

	stop {
		rout.stop;
	}

    start {
		rout.play;
	}
}
*/
