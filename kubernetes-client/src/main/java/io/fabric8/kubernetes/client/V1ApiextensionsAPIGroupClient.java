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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1ApiextensionsAPIGroupClient extends ClientAdapter<V1ApiextensionsAPIGroupClient>
    implements V1ApiextensionAPIGroupDSL {

  @Override
  public MixedOperation<CustomResourceDefinition, CustomResourceDefinitionList, Resource<CustomResourceDefinition>> customResourceDefinitions() {
    return resources(CustomResourceDefinition.class, CustomResourceDefinitionList.class);
  }

  @Override
  public V1ApiextensionsAPIGroupClient newInstance() {
    return new V1ApiextensionsAPIGroupClient();
  }
}
