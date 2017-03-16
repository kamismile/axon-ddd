package com.dms.core.req.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.scheduling.EventScheduler;
import org.axonframework.eventhandling.scheduling.ScheduleToken;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.EndSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.core.req.evt.CReqApplicationEvt;

public class ReqApplicationSaga extends AbstractAnnotatedSaga {

	private static final long serialVersionUID = 1798051388403504162L;

	@Autowired
    private transient CommandGateway commandGateway;
	@Autowired
    private transient EventScheduler eventScheduler;

    private ScheduleToken deadline;

/*    @StartSaga
    @SagaEventHandler(associationProperty = "reqAppId")
    public void onToDoItemCreated(CReqApplicationEvt evt) {
        deadline = eventScheduler.schedule(Duration.standardSeconds(2),
                                           new ReqAppDeadlineExpiredEvt(evt.getReqAppId()));
    }*/
/*
    @SagaEventHandler(associationProperty = "reqAppId")
    public void onDeadlineExpired(ReqAppDeadlineExpiredEvt evt) {
        commandGateway.send(new MarkReqAppCompletedEvt(evt.getReqAppId()));
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "reqAppId")
    public void onToDoItemCompleted(MarkReqAppCompletedEvt evt) {
        if (deadline != null) {
            eventScheduler.cancelSchedule(deadline);
        }
    }*/
}
