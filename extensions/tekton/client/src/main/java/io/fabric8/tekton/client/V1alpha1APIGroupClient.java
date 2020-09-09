/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.tekton.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.tekton.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.tekton.client.internal.v1alpha1.*;
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTask;
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTaskList;
import io.fabric8.tekton.pipeline.v1alpha1.Condition;
import io.fabric8.tekton.pipeline.v1alpha1.ConditionList;
import io.fabric8.tekton.pipeline.v1alpha1.DoneableClusterTask;
import io.fabric8.tekton.pipeline.v1alpha1.DoneableCondition;
import io.fabric8.tekton.pipeline.v1alpha1.DoneablePipeline;
import io.fabric8.tekton.pipeline.v1alpha1.DoneablePipelineRun;
import io.fabric8.tekton.pipeline.v1alpha1.DoneableTask;
import io.fabric8.tekton.pipeline.v1alpha1.DoneableTaskRun;
import io.fabric8.tekton.pipeline.v1alpha1.Pipeline;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineList;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRun;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunList;
import io.fabric8.tekton.pipeline.v1alpha1.Task;
import io.fabric8.tekton.pipeline.v1alpha1.TaskList;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRun;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunList;
import io.fabric8.tekton.resource.v1alpha1.DoneablePipelineResource;
import io.fabric8.tekton.resource.v1alpha1.PipelineResource;
import io.fabric8.tekton.resource.v1alpha1.PipelineResourceList;
import io.fabric8.tekton.triggers.v1alpha1.*;
import io.fabric8.tekton.triggers.v1alpha1.DoneableClusterTriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.DoneableEventListener;
import io.fabric8.tekton.triggers.v1alpha1.DoneableTriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.DoneableTriggerTemplate;
import okhttp3.OkHttpClient;

public class V1alpha1APIGroupClient extends BaseClient implements V1alpha1APIGroupDSL {
  public V1alpha1APIGroupClient() {
    super();
  }

  public V1alpha1APIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Pipeline, PipelineList, DoneablePipeline, Resource<Pipeline, DoneablePipeline>> pipelines() {
    return new PipelineOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<PipelineRun, PipelineRunList, DoneablePipelineRun, Resource<PipelineRun, DoneablePipelineRun>> pipelineRuns() {
    return new PipelineRunOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<PipelineResource, PipelineResourceList, DoneablePipelineResource, Resource<PipelineResource, DoneablePipelineResource>> pipelineResources() {
    return new PipelineResourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Task, TaskList, DoneableTask, Resource<Task, DoneableTask>> tasks() {
    return new TaskOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<TaskRun, TaskRunList, DoneableTaskRun, Resource<TaskRun, DoneableTaskRun>> taskRuns() {
    return new TaskRunOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Condition, ConditionList, DoneableCondition, Resource<Condition, DoneableCondition>> conditions() {
    return new ConditionOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<TriggerTemplate, TriggerTemplateList, DoneableTriggerTemplate, Resource<TriggerTemplate, DoneableTriggerTemplate>> triggerTemplates() {
    return new TriggerTemplateOperationsImpl(this.getHttpClient(),this.getConfiguration());
  }

  @Override
  public MixedOperation<TriggerBinding, TriggerBindingList, DoneableTriggerBinding, Resource<TriggerBinding, DoneableTriggerBinding>> triggerBindings() {
    return new TriggerBindingOperationsImpl(this.getHttpClient(),this.getConfiguration());
  }

  @Override
  public MixedOperation<EventListener, EventListenerList, DoneableEventListener, Resource<EventListener, DoneableEventListener>> eventListeners() {
    return new EventListenerOperationsImpl(this.getHttpClient(),this.getConfiguration());
  }

  @Override
  public NonNamespaceOperation<ClusterTask, ClusterTaskList, DoneableClusterTask, Resource<ClusterTask, DoneableClusterTask>> clusterTasks() {
    return new ClusterTaskOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public NonNamespaceOperation<ClusterTriggerBinding, ClusterTriggerBindingList, DoneableClusterTriggerBinding, Resource<ClusterTriggerBinding, DoneableClusterTriggerBinding>> clusterTriggerBindings() {
    return new ClusterTriggerBindingOperationsImpl(this.getHttpClient(),this.getConfiguration());
  }
}
