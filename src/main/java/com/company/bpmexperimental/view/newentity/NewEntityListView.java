package com.company.bpmexperimental.view.newentity;

import com.company.bpmexperimental.entity.NewEntity;
import com.company.bpmexperimental.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormViews;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "newEntities", layout = MainView.class)
@ViewController("exp_NewEntity.list")
@ViewDescriptor("new-entity-list-view.xml")
@LookupComponent("newEntitiesDataGrid")
@DialogMode(width = "64em")
public class NewEntityListView extends StandardListView<NewEntity> {
    @ViewComponent
    private JmixButton startBtn;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessFormViews processFormViews;

    @Subscribe(id = "startBtn", subject = "clickListener")
    public void onStartBtnClick(final ClickEvent<JmixButton> event) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("vedomostzi-to-kb")
                .latestVersion()
                .singleResult();

        processFormViews.openStartProcessForm(processDefinition, this, dialogWindow -> {
            // Customization logic for the dialog window
            dialogWindow.setDraggable(false);

            System.out.println("Dialog window customization logic here");
        });
//        processFormViews.openStartProcessForm(processDefinition,this);

    }
}