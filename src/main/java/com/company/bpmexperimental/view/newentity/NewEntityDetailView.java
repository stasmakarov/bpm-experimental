package com.company.bpmexperimental.view.newentity;

import com.company.bpmexperimental.entity.NewEntity;
import com.company.bpmexperimental.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "newEntities/:id", layout = MainView.class)
@ViewController("exp_NewEntity.detail")
@ViewDescriptor("new-entity-detail-view.xml")
@EditedEntityContainer("newEntityDc")
public class NewEntityDetailView extends StandardDetailView<NewEntity> {
}