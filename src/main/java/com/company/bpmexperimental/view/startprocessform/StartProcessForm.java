package com.company.bpmexperimental.view.startprocessform;


import com.company.bpmexperimental.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpm.data.form.FormData;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.core.Messages;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outputVariables = {
        @OutputVariable(name = "name", type = String.class),
        @OutputVariable(name = "size", type = Long.class)
})
@Route(value = "start-process-form", layout = MainView.class)
@ViewController("exp_StartProcessForm")
@ViewDescriptor("start-process-form.xml")
public class StartProcessForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "name")
    @ViewComponent
    private TypedTextField<String> nameField;
    @ProcessVariable(name = "size")
    @ViewComponent
    private TypedTextField<Long> sizeField;

    @Autowired
    private Messages messages;

    @Subscribe(id = "startProcessBtn", subject = "clickListener")
    protected void onStartProcessBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.getFormData();
        processFormContext.processStarting()
                .saveInjectedProcessVariables()
                .start();
        closeWithDefaultAction();
//        messageLabel.setText("Отправить Ведомость ЗИ "+ vedomostNumber + " в КБ");
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {

    }


}