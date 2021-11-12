if [ ! -z $(git diff --name-only HEAD HEAD~1 | grep dependencies.gradle) ]; then
  new_version="$(git log -n1 --format=format:"%H")"
  sed --in-place "s!//version:.*!//version: $new_version!g" build.gradle
  git add build.gradle
  git commit -m "[ci skip] update buildscript version to $new_version"
  git push
  echo "updated buildscript version to $new_version"; 
else
  echo "no buildscript changes detected - ignoring version update"
fi
