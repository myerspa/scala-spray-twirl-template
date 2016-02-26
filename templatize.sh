#!/bin/bash

echo -n 'Project Name: '
read PROJECT_NAME

echo -n 'Organization: '
read ORGANIZATION

# echo -n 'Organization Homepage: '
# read ORGANIZATION_HOMEPAGE

# echo -n 'Description: '
# read DESCRIPTION

echo -n 'Start Year: '
read START_YEAR

echo -n 'Default Package: '
read DEFAULT_PACKAGE

find ./* -type f -exec sed -i 's/{{PROJECT_NAME}}/'$PROJECT_NAME'/g' {} \;
find ./* -type f -exec sed -i 's/{{ORGANIZATION}}/'$ORGANIZATION'/g' {} \;
# find ./* -type f -exec sed -i 's/{{ORGANIZATION_HOMEPAGE}}/'$ORGANIZATION_HOMEPAGE'/g' {} \;
# find ./* -type f -exec sed -i 's/{{DESCRIPTION}}/'$DESCRIPTION'/g' {} \;
find ./* -type f -exec sed -i 's/{{START_YEAR}}/'$START_YEAR'/g' {} \;
find ./* -type f -exec sed -i 's/{{DEFAULT_PACKAGE}}/'$DEFAULT_PACKAGE'/g' {} \;
