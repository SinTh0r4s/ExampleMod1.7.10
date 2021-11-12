if [ ! -z $(git diff --name-only HEAD HEAD~1 | grep dependencies.gradle) ]; then
  new_version="$(git log -n1 --format=format:"%H")"
  sed --in-place "s!//version:.*!//version: $new_version!g" build.gradle
  git add build.gradle
  git commit -m "update buildscript version to $new_version"
  git push
  echo "[ci skip] update buildscript version"; 
fi
