package edu.nju.soa.resolver;

import edu.nju.soa.handler.LogHandler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2017-06-26.
 *
 */
public class DefaultResolver implements HandlerResolver {
    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {

        List<Handler> handlers = new ArrayList<>();
        handlers.add(new LogHandler());

        return handlers;
    }
}
