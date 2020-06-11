#!/usr/bin/env bash
echo "preparing..."

export VERSION=
export PROJECT_ID=
export APP_NAME=
export GC_KUBERNETES_ZONE=
export GC_KUBERNETES_CLUSTER=
export GC_KUBERNETES_NAMESPACE=default
export CREDENTIALS_PATH=
export SERVICE_ACCOUNT=

echo "activate service-account"
gcloud auth activate-service-account ${SERVICE_ACCOUNT} --key-file=${CREDENTIALS_PATH} --project ${PROJECT_ID}

#gcloud auth configure-docker

sudo docker build --no-cache -t ${APP_NAME}:${VERSION} .
sudo docker tag ${APP_NAME}:${VERSION} gcr.io/${PROJECT_ID}/${APP_NAME}:${VERSION}
sudo docker push gcr.io/${PROJECT_ID}/${APP_NAME}:${VERSION}


cat deploy/deployment.yaml | \
sed s/PROJECT_ID/${PROJECT_ID}/ | \
sed s/APP_NAME/${APP_NAME}/ | \
sed s/VERSION/${VERSION}/ | kubectl delete --ignore-not-found=true --namespace default -f -

cat deploy/deployment.yaml | \
sed s/PROJECT_ID/${PROJECT_ID}/ | \
sed s/APP_NAME/${APP_NAME}/ | \
sed s/VERSION/${VERSION}/ | kubectl create  --namespace default -f -

